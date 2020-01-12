<template>
    <div id="app">
        <v-toolbar flat color="grey">
            <v-text-field
                          append-icon="mdi-search-web"
                          label="Search"
                          solo-inverted
                          class="mx-12"
                          ></v-text-field>
        </v-toolbar>
            <v-tabs slot="extension"
                    centered
                    slider-color="white"
                    color="">
                <v-tab>Collection</v-tab>
                <v-tab>Current</v-tab>
                <v-tab>Read</v-tab>
                <v-tab>Account</v-tab>
                <v-tab-item>
                    <collection></collection>
                </v-tab-item>
                <v-tab-item>
                    <current></current>
                </v-tab-item>
                <v-tab-item>
                    <read></read>
                </v-tab-item>
                <v-tab-item>Four</v-tab-item>

            </v-tabs>
    </div>
</template>


<script>
    import Collection from "@/components/Collection";
    import Current from "@/components/Current";
    import Read from "@/components/Read";
    const AppBar = {
        name: 'AppBar',
        components:{
            Collection,
            Current,
            Read,
        },
        props:{
            activeUser : Object
        },
        data: function () {
            return{
                types: []
            }
        },
        mounted() {
        },
        methods: {

        }
    }

    export default AppBar
</script>

<style scoped>

</style>