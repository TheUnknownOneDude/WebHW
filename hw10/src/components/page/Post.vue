<script setup>

import ArticleTemplate from "@/components/page/article/ArticleTemplate.vue";
</script>

<template>
    <div>
        <ArticleTemplate :post="post" :commentsCount="commentsCount" :with-href="false"/>

        <div class="enter form-box">
            <div class="header">Enter</div>
            <div class="body">
                <form @submit.prevent="onComment">
                    <div class="field">
                        <div class="name">
                            <label for="login">Text</label>
                        </div>
                        <div class="value">
                            <input autofocus id="text" name="text" v-model="text"/>
                        </div>
                    </div>
                    <div class="field error">{{ error }}</div>
                    <div class="button-field">
                        <input type="submit" value="Enter">
                    </div>
                </form>
            </div>
        </div>

    <article v-for="comment in postComments" v-bind:key="comment.id">
        <div class="information">By user with id: {{comment.userId}}</div>
        <div class="body">{{comment.text}}</div>
        <div class="footer">
            <div class="left">
                <img src="../../assets/img/voteup.png" title="Vote Up" alt="Vote Up"/>
                <span class="positive-score">+1</span>
                <img src="../../assets/img/votedown.png" title="Vote Down" alt="Vote Down"/>
            </div>
            <div class="right">
                <img src="../../assets/img/date_16x16.png" title="Publish Time" alt="Publish Time"/>
                 long ago
            </div>
        </div>
    </article>
    </div>
</template>

<script>
export default {
    name: "Post",

    props: ["post", "comments"],

    data: function () {
        return {
            text: "",
            error: ""
        }
    },
    methods: {
        onComment: function () {
            this.$root.$emit("onComment", this.post.id, this.text);
        }
    },

    computed: {

        postId: function () {
            return this.post.id
        },

        postComments: function () {
            return Object.values(this.comments).filter(u => u.postId === this.post.id)
        },

        commentsCount: function () {
            return this.postComments.length
        },
    },

    beforeCreate() {
        this.$root.$on("onCommentingError", (error) => this.error = error);
    }
}
</script>
<style scoped>

</style>