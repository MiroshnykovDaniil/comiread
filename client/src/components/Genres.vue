<template>
    <div>
        <h1>Genres</h1>
        <ul>
            <li v-for="genre in genres" :key="genre.id">
                {{genre.name}}
            </li>
        </ul>
    </div>
</template>

<script>
    import api from "../Api"

    const Genres = {
        name: 'Genres',
        props:{
            activeUser : Object
        },
        data: function () {
            return{
                genres: []
            }
        },
        mounted() {
            api.getGenres()
                .then(response => {
                    this.$log.debug("Data loaded: ", response.data)
                    this.genres = response.data
                })
                .catch(error => {
                    this.$log.debug(error)
                    this.error = "Failed to load Genres"
                })
                .finally(() => this.loading = false)
        },
        methods: {

        }
    }

    export default Genres
</script>

<style scoped>

</style>