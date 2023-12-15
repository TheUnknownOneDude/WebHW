<template>
    <div>
        <ArticleTemplate v-for="post in posts" v-bind:key="post.id" :post="post"/>
    </div>
</template>

<script>
import ArticleTemplate from "@/components/page/article/ArticleTemplate.vue";

export default {
    name: "Index",
    components: {ArticleTemplate},

    props: ["posts"]
}
</script>

<style scoped>

</style>