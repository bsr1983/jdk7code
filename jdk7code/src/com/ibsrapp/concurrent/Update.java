package com.ibsrapp.concurrent;

/**
 * Created with IntelliJ IDEA.
 * User: billlee
 * Date: 2014/11/17
 * Time: 15:14
 * To change this template use File | Settings | File Templates.
 */
public class Update {
    private final Author author;
    private final String updateText;
    private Update(Builder b_)
    {
        author=b_.author;
        updateText=b_.updateText;
    }
    public static class Builder implements ObjBuilder<Update>
    {
        private Author author;
        private String updateText;
        public Builder author(Author author_)
        {
            author=author_;
            return this;
        }
        public Builder updateText(String updateText_)
        {
            updateText=updateText_;
            return this;
        }
        public Update build()
        {
            return new Update(this);
        }
    }

    public static void main(String[] args) {
        Update.Builder ub=new Update.Builder();
        Update u=ub.author(new Author("")).updateText("Text").build();
    }
}
