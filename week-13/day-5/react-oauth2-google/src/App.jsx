import { useState } from 'react';
import './App.css'

function App() {

  const [userInfo, setUserInfo] = useState('');


  function handleLogin() {
    /**
     * With OAuth2, you can't just send an HTTP request to an endpoint that requires authentication, 
     * without having a JSESSIONID cookie. 
     * 
     * we manually redirect the browser to the sign-in endpoint
     */
    window.location.replace('http://localhost:8080/signin');  // replace the url in the browser


    console.log('WE LOGGED IN!!!');
  }


  function getuserInfo() {

    // make sure to INCLUDE CREDENTIALS so your request can be validated by CORS
    fetch('http://localhost:8080/user-info', { credentials: 'include', method: 'GET' }) 
      .then(data => data.text()) 
      .then(userInfo => setUserInfo(userInfo))
  }

  return (
    <>
      <h1>Google OAuth2 Demo!!!!!</h1>

      <button onClick={handleLogin}>Sign In</button>
      <button onClick={getuserInfo}>Get User Info</button>

      <h3>User Info:</h3>
      {userInfo}
    </>
  )
}

export default App
