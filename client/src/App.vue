<template>
  <v-app>
    <app-bar></app-bar>
<!--    <collection></collection>-->
    <!--    <comics></comics>-->

  </v-app>
</template>

<script>
 // import Comics from "@/components/Comics";
import AppBar from "@/components/AppBar";
// import NavBar from "@/components/NavBar";
//  import Collection from "@/components/Collection";
export default {
  name: 'App',

  components: {
     // Comics,
    AppBar,
    // Collection,
   //  NavBar
  },

  data: function () {
      return{

      }
  },
    methods:{
    Counter(){
        this.text=2;
    }
}

};
</script>
