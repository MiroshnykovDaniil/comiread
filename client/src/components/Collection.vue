<template>
    <div>
        <v-container>
            <v-row>
                <v-col v-for = "comics in collection" :key="comics.id" :cols="3">
                    <v-card max-width="300">
                        <v-img max-height="100px" max-width="100"  v-bind:src="'data:image/jpg;base64,'+comics.image"></v-img>
                        <v-card-title onclick="this.lol++">{{comics.name}}</v-card-title>
                            <v-card-subtitle>{{comics.status}}</v-card-subtitle>
                        <v-card-actions>
                            <v-spacer></v-spacer>

                            <v-btn>
                                <v-icon>mdi-heart</v-icon>
                            </v-btn>
                        </v-card-actions>

                    </v-card>
                </v-col>
            </v-row>

        </v-container>

    </div>
</template>

<script>
    import api from "../Api"

    const Collection = {
        name: 'Collection',
        props:{
            activeUser : Object
        },
        data: function () {
            return{
                collection:"S",
                pictures :[],
                lol:0
            }
        },
        mounted() {
            api.getCollection()
                .then(response => {
                    this.$log.debug("Data loaded: ", response.data)
                    this.collection = response.data
                    this.getImg();
                })
                .catch(error => {
                    this.$log.debug(error)
                    this.error = "Failed to load Collection"
                })
                .finally(() => this.loading = false)
        },
        methods: {
            getImg(){
                for(var i = 0; i<this.collection.length;i++){
                    api.getImg(this.collection[i].name)
                        .then(response =>{
                            this.pictures.add =response.data
                        })
                }
            },
            click(){
               this.lol++;
            }
        }
    }

    export default Collection
</script>

<style scoped>

</style>