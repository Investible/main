package com.codeup.investible.controllers.form;

import javax.validation.constraints.Size;


    public class NewCommentForm {

        @Size(min = 3, message = "{Size.Post.content.validation}")
        private String body;

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }

    }


