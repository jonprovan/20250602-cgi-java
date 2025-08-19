import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import App from './App.tsx'

// this is the root component of our application, holding the App component and everything within it
// note how we're placing the App component in this component below
// what's in the render() method is TSX -- TypeScript combined with HTML
createRoot(document.getElementById('root')!).render(
  <StrictMode>
    <App />
  </StrictMode>,
)
