<template>
  <div>
    
    <h1>
    {{bruh}}
    </h1>
    <button v-on:click="send()">Send packet</button>
  </div>
</template>

<script>
import io from 'socket.io-client'
export default {
  
  name: 'MangaPage',
   data() {
    return {
      
      bruh: 'No data has been sent nor received.'
  
  };
  },
  created() {
    this.socket = io(); // this is for an official deployment.
    // YOU HAVE TO USE LINE 24 if you're using the java server.
    // CORS is just fucked up and broken on the java lib for socketio.
    // What I did was use this and the code on the server and then
    // use nginx to proxy port 3000 to port 8080/443 or whatever

    this.socket.on('REQUEST_NEW_MANGA', (data) => {
      this.bruh = data.string;
    });

  },
  methods: {
    send() {
      this.socket.emit('REQUEST_NEW_MANGA', 'test');
    }
  }
}
</script>

<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>