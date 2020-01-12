<template>
    <div></div>
    <!--
    <div>
        <p>Current page: {{pageNumber}}</p>
        <v-btn @click="prevPage">
            Prev
        </v-btn>
        <v-btn @click="nextPage">
            Next
        </v-btn>
        <li v-for="picture in current" :key="picture.name">
            <v-row align="center" justify="center">
                <img v-bind:src="'data:image/jpg;base64,'+picture" class="preview">
            </v-row>
        </li>
    </div>
    -->
</template>

<script>
    import api from "../Api"

    const comicsName = "Kono suba 2";
    const vol ="1";
    const name ="Chapter 2";

    const Comics = {
        name: 'Comics',
        props:{
            activeUser : Object,
            size:{
                type:Number,
                default: 1
            }
        },
        data: function () {
            return{
                pageNumber:1,
                current:[],
                comics: [],
            }
        },
        mounted() {
            api.getPictures(comicsName,vol,name)
                .then(response => {
                    this.$log.debug("Data loaded: ", response.data)
                    this.comics = response.data
                    this.allPages = this.comics.count / 3;
                    this.paginatedData();
                })
                .catch(error => {
                    this.$log.debug(error)
                    this.error = "Failed to load Genres"
                })
                .finally(() => this.loading = false)
        },
        methods:{
            nextPage(){
                this.pageNumber++;
                this.paginatedData();
            },
            prevPage(){
                this.pageNumber--;
                this.paginatedData();
            },
            pageCount(){
                let l = this.comics.length,
                    s = this.size;
                return Math.ceil(l/s);
            },
            paginatedData(){
                const start = this.pageNumber * this.size,
                    end = start + this.size;
                this.current = this.comics.slice(start, end);
            }
        }
    }

    export default Comics
</script>

<style scoped>

</style>