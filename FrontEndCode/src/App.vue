<template>
  <div id="app">
  <div id='menu'>
    <Menu></Menu>
  </div>
    <router-view/>
  <div id='footer'>
    <Footer></Footer>
  </div>
  </div>
</template>

<script>
import Menu from './components/Menu.vue'
import Footer from './components/Footer.vue'
export default {
  name: 'App',
  components: {
    'Menu': Menu,
    'Footer': Footer
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
  background-color: rgba(240, 240, 240,0.5);
}
</style>
