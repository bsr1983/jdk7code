package com.ibsrapp.concurrent.pets;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;
import java.util.concurrent.atomic.AtomicLong;

public class Veterinarian extends Thread {
  protected final TransferQueue<Appointment<Pet>> appts;
  protected String text = "";
  protected final int restTime;
  private boolean shutdown = false;
  private final static AtomicLong atomicLong=new AtomicLong(0);
  public Veterinarian(TransferQueue<Appointment<Pet>> lbq, int pause) {
    appts = lbq;
    restTime = pause;
  }

  public synchronized void shutdown() {
    shutdown = true;
  }

  @Override
  public void run() {
    while (!shutdown) {
      seePatient();
      try {
        Thread.sleep(restTime);
          appts.add(new Appointment(new Cat("my Cat "+atomicLong.getAndIncrement())));
          appts.add(new Appointment(new Cat("my Cat "+atomicLong.getAndIncrement())));
          appts.add(new Appointment(new Cat("my Cat "+atomicLong.getAndIncrement())));
          appts.add(new Appointment(new Cat("my Cat "+atomicLong.getAndIncrement())));
      } catch (InterruptedException e) {
        shutdown = true;
      }
    }
  }

  public void seePatient() {
    try {
      Appointment<Pet> ap = appts.take();
      Pet patient = ap.getPatient();
      patient.examine();
    } catch (InterruptedException e) {
      shutdown = true;
    }
  }

    public static void main(String[] args) {
        TransferQueue<Appointment<Pet>> lbq=new LinkedTransferQueue<Appointment<Pet>>();
        lbq.add(new Appointment(new Cat("my Cat 1"+atomicLong.getAndIncrement())));
        lbq.add(new Appointment(new Dog("my Dog 1"+atomicLong.getAndIncrement())));
        lbq.add(new Appointment(new Cat("my Cat 2"+atomicLong.getAndIncrement())));
        lbq.add(new Appointment(new Dog("my Dog 2"+atomicLong.getAndIncrement())));
        lbq.add(new Appointment(new Cat("my Cat 3"+atomicLong.getAndIncrement())));
        lbq.add(new Appointment(new Dog("my Dog 3"+atomicLong.getAndIncrement())));
        Veterinarian veter=new Veterinarian(lbq,500);
        veter.start();
        lbq.add(new Appointment(new Cat("my Cat 1"+atomicLong.getAndIncrement())));
        lbq.add(new Appointment(new Dog("my Dog 1"+atomicLong.getAndIncrement())));
        lbq.add(new Appointment(new Cat("my Cat 2"+atomicLong.getAndIncrement())));
        lbq.add(new Appointment(new Dog("my Dog 2"+atomicLong.getAndIncrement())));

    }
}