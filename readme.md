# Vue Button Demo
This is the button demo which allows a webpage to communicate with a Java backend using Vuejs & Socketio libraries.

The packages are using my manga.surf domain. I plan to rework this into the front and backend of the manga.surf website.

## GIF Output
Here's a gif output of everything working. Take note that when the client reloads the webpage, the server keeps track of the button presses.

![Gif](https://i.imgur.com/kSrDdXg.gif)

## Important
### Note about npm dependency
When installing the socket.io client, you will need to run `npm install --save vue-socket.io@3.0.10` otherwise the socket.io server will not work. And you might spend a few hours trying to get it working. Which happened to me as I was trying to use this project two years after I had used it previously.
