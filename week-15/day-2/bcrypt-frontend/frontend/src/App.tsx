import { useRef } from 'react'
import './App.css'
import bcrypt from 'bcryptjs'; // importing the entirety of bcrypt to use here

function App() {

  const username = useRef('');
  const password = useRef('');

  async function submit() {
    const appUser = {
      id: 0,
      username: username.current.value,
      password: password.current.value,
      role: 'none'
    }

    console.log(appUser);

    const hashedPassword = await bcrypt.hash(password.current.value, 10);
    console.log(hashedPassword);

    appUser.password = hashedPassword;

    console.log(appUser);

  }
  

  return (
    <main>

      <form>
        <h2>REGISTER FORM</h2>
        <div>
          <label htmlFor="username">Username: </label>
          <input type="text" name="username" id="username" ref={username} />
        </div>
        <div>
          <label htmlFor="password">Password: </label>
          <input type="password" name="password" id="password" ref={password} />
        </div>
        <button type='button' onClick={() => submit()}>SUBMIT</button>
      </form>

    </main>
  )
}

export default App
