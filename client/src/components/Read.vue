<template>
    <div>
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
        <p>{{chapter}}</p>
    </div>
</template>

<script>
    import {bus} from "@/main";

    const Read = {
        name: 'Read',
        props:{
            activeUser : Object
        },
        data: function () {
            return{
                chapter:"STR",
                images:[],
                pageNumber:1,
                current:[],
                size:1,
            }
        },
        created() {
            bus.$on('images', (data) => {
                this.images = data;}
                );
            this.read(this.images);
        },
        methods: {
            read(images){
            this.images = images;
            },
            nextPage(){
                this.pageNumber++;
                this.paginatedData();
            },
            prevPage(){
                this.pageNumber--;
                this.paginatedData();
            },
            pageCount(){
                let l = this.images.length,
                    s = this.size;
                return Math.ceil(l/s);
            },
            paginatedData(){
                const start = this.pageNumber * this.size,
                    end = start + this.size;
                this.current = this.images.slice(start, end);
            }
        }
    }

    export default Read

</script>

<style scoped>

</style>