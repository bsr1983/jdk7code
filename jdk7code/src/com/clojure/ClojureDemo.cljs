(ns com.clojure.ClojureDemo)
(def hello (fn [] "Hello world"))
(hello)
;使用java中的toString()结合length()获取字符串长度
(defn lenStr [y] (.length (.toString y)))
(defn schwartz [x f]
      (map #(nth %1 0)
           (sort-by #(nth %1 1)
                    (map #(let [w %1] (list w (f w)))x))))
(schwartz ["sads" "21" "ssssewe" "22323" "223" "s"] lenStr)
'(1 2 3 4 5)
(quote (1 23 45 32 545))
(vector 1 2 3)
(vec '(1 2 3 4 5))
[1 2 3 4 5 4 5 2]
["ssa" 2 "dsadsa" "321" 221]
(nth '(1 2 3 "433" "rewr" "e33") 4)
(def foo {"aaa" "111" "bbb" 22222})
(foo "aaa")
(foo "bbb")
(def martijn {:name "Martijn Verburg",:city "London",:area "Highbury"})
(:name martijn)
(:city martijn)
(def ben {:name "ben Evans",:city "London",:area "Holloway"})
(def authors [ben martijn])
(map ( fn [y] (:name y)))
(map ( fn [y] (:name y)) authors)
(+ 3 4)
(defn add [x y] (+ x y))
(+ 2 3 4 56)
(def list-int '(1 2 3 4))
(def vect-int (vec list-int))
(identical? list-int vect-int)
(defn const-fun1 [y] 1)
(defn iden-fun [y] y)
(defn list-maker-fun [x f]
      (map (fn [z] (let [w z]
                        (list w (f w))))x))
(list-maker-fun ["a"] const-fun1)
(list-maker-fun ["a" "b"] const-fun1)
(list-maker-fun [3 4 65] iden-fun)
(schwartz [33 452 53 42 555] iden-fun)
(defn like-for [counter]
      (loop [ctr counter]
            (println ctr)
            (if (< ctr 10)
              (recur (inc ctr))
              ctr)))
(like-for 100)
(like-for 60)
(like-for 6)
(like-for 1)
(defn like-for [counter]
      (loop [ctr counter]
            (println ctr)
            (if (< ctr 100)
              (recur (inc ctr))
              ctr)))
(like-for 99)
(like-for 1)
(defn adder [constToAdd] #(+ constToAdd %1))
(def plus2 (adder 2))
(plus2 222)
(def plus100 (adder 100))
(plus100 22)
(rest '(1 2 3))
(first '(1 2 43 54))
(rest [1 23 45])
(seq ())
(seq [])
(seq '(1 2 3 4))
(seq [22 1 "re" "fdsw" "fdsf" "fdsffd"])
(cons 1 [2 34 43])
(defn next-big-n [n] (let [new-val (+ 1 n)]
                          (lazy-seq (
                                      cons new-val (next-big-n new-val)
                                           ))))
(defn natural-k [k]
      (concat [k] (next-big-n k)))
(take 10 (natural-k 3))
(defn const-fun-arity1
      ([] 1)
      ([x] 1)
      ([x & more] 1))
(const-fun-arity1 1)
(const-fun-arity1 1 2)
(const-fun-arity1 1 2 3)
(defn const-fun-arity1
      ([] 0)
      ([x] 1)
      ([x & more] "more"))
(const-fun-arity1)
(const-fun-arity1 1 )
(const-fun-arity1 1 2 3)
(System/getProperty "java.vm.version")
(import '(java.util.concurrent CountDownLatch LinkedBlockingQueue))
(def cdl (new CountDownLatch 2))
(def lbq (LinkedBlockingQueue.))
(.getClass "test")
(.getClass 2.3)
(.getClass [12 34 534])
(.getClass '(1 2 3 4))
(.getClass (fn [] "Hello world"))
(import '(java.util.concurrent Executors LinkedBlockingQueue TimeUnit))
(def stpe (Executors/newScheduledThreadPool 2))
(def lbq (LinkedBlockingQueue.))
(def msgRdr (proxy [Runnable] []
                   (run [] (.toString (.poll lbq)))))
(def rdrHndl (.scheduleAtFixedRate stpe msgRdr 10 10 TimeUnit/MILLISECONDS))
(import '(java.util ArrayList LinkedList))
(.getClass (.iterator (ArrayList.)))
(.getClass (.iterator (LinkedList.)))
(def simple-future (future (do (println "hello world Line0")
                               (Thread/sleep 10000)
                               (println "we are the world Line1")
                               (Thread/sleep 10000)
                               (println "do the best Line 2"))))
(defn wait-with-for [limit]
      (let [counter 1]
           (loop [ctr counter]
                 (Thread/sleep 500)
                 (println (str "Ctr=" ctr))
                 (if (< ctr limit)
                   (recur (inc ctr))
                   ctr))))
(defn wait-1 [] (wait-with-for 1))
(defn wait-2 [] (wait-with-for 2))
(defn wait-3 [] (wait-with-for 3))
(def wait-seq (pcalls wait-1 wait-2 wait-3))
(first wait-seq)
(first (next wait-seq))
(defn make-new-acc [account-name opening-balance]
      {:name account-name :bal opening-balance})
(defn loop-and-debit [account]
      (loop [acc account]
            (let [balance (:bal acc) my-name (:name acc)]
                 (Thread/sleep 1)
                 (if (> balance 0)
                   (recur (make-new-acc my-name (dec balance)))
                   acc))))
(loop-and-debit (make-new-acc "Ben" 600))
(defn make-new-acc [account-name opening-balance]
      (ref {:name account-name :bal opening-balance}))
(defn alter-acc [acc new-name new-balance]
      (assoc acc :bal new-balance :name new-name))

(defn loop-and-debit [account]
      (loop [acc account]
            (let [balance (:bal @acc)
                  my-name (:name @acc)]
                 (Thread/sleep 1)
                 (if (> balance 0)
                   (recur (dosync (alter acc alter-acc my-name (dec balance)) acc))
                   acc)
                 )))
(def my-acc (make-new-acc "Ben" 500))
(defn my-loop [] (let [the-acc my-acc]
                      (loop-and-debit the-acc)))
(pcalls my-loop my-loop my-loop my-loop my-loop)
(defn wait-and-log [coll str-to-add]
      (do (Thread/sleep 10000)
          (let [my-coll (conj coll str-to-add)]
               (Thread/sleep 10000)
               (conj my-coll str-to-add))))
(def str-coll (agent []))
(send str-coll wait-and-log "some str")
@str-coll