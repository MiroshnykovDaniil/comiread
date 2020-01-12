<template>
    <v-col>
        <v-col>
           <h1>{{card.name}}</h1>
        </v-col>
        <v-img max-height="300px" max-width="200" v-bind:src="'data:image/jpg;base64,'+card.image"></v-img>
        <v-col>
            <h2>Type: {{card.type.name}}</h2>
        </v-col>
        <div class="text-left">
            <h2>Genres:</h2>
            <v-chip active class="ma-1" v-for = "genre in card.genres" :key="genre.id">{{genre.name}}</v-chip>
        </div>
        <h2>Chapters:</h2>
        <v-col v-for = "chapter in this.chapters" :key="chapter.id">
            <v-btn text @click="startReading(chapter)">{{chapter.volume.volumeNum}} - {{chapter.num}} : {{chapter.name}}</v-btn>
        </v-col>
    </v-col>
</template>

<script>
    import {bus} from "@/main";
    import Api from "@/Api";

    const Current = {
        name: 'Current',
        props: {
            activeUser: Object
        },
        data: function () {
            return {
                types: [],
                card: "TEXT",
                chapters: [],
                images:[]
            }
        },
        created() {
            bus.$on('card', (data) => {
                this.card = data;

            })
            this.getChapters();
        },
        methods: {
            getChapters() {
                bus.$on('chapters', (data) => {
                    this.chapters = data
                })
            },
            startReading(chapter){
                Api.getPictures(chapter.comics.name,chapter.volume.volumeNum,chapter.name)
                    .then(response => {
                        this.$log.debug("Data loaded: ")
                        this.images = response.data
                    })
                    .catch(error => {
                        this.$log.debug(error)
                        this.error = "Failed to load Collection"
                    })
                    .finally(() => this.loading = false);
                bus.$emit('images',this.images);
            }
        }
    }

    export default Current
</script>


<style scoped>

</style>