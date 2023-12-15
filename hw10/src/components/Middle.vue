<template>
    <div class="middle">
        <Sidebar :posts="viewPosts"/>
        <main>
            <Index v-if="page === 'Index'" :posts="posts" :comments="comments"/>
            <Post v-if="page === 'Post'" :post="posts[postId]" :comments="comments"  />
            <Users v-if="page === 'Users'" :users="users"/>
            <Enter v-if="page === 'Enter'"/>
            <Register v-if="page === 'Register'"/>
            <WritePost v-if="page === 'WritePost'"/>
            <EditPost v-if="page === 'EditPost'"/>
        </main>
    </div>
</template>

<script>
import Sidebar from "./sidebar/Sidebar";
import Index from "./page/Index";
import Enter from "./page/Enter";
import WritePost from "./page/WritePost";
import EditPost from "./page/EditPost";
import Register from "./page/Register.vue";
import Users from "./page/Users.vue";
import Post from "@/components/page/Post.vue";

export default {
    name: "Middle",
    data: function () {
        return {
            postId: "",
            page: "Index"
        }
    },
    components: {
        Post,
        Users,
        WritePost,
        Enter,
        Register,
        Index,
        Sidebar,
        EditPost
    },
    props: ["posts", "users", "comments", ],
    computed: {
        viewPosts: function () {
            return Object.values(this.posts).sort((a, b) => b.id - a.id).slice(0, 2);
        }
    }, beforeCreate() {
        this.$root.$on("onChangePage", (page) => this.page = page)
        this.$root.$on("onChangePageWithId", (page, postId) =>  {
            this.page = page
            this.postId = postId
        })
    }
}
</script>

<style scoped>

</style>
