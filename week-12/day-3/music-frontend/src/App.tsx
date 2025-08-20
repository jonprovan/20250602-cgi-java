import './App.css'
// imports use object destructuring
// you can import several different things from the same file by comma-separating them
// we need this to implement routing functionality
import { BrowserRouter, Route, Routes } from 'react-router'
import { Artists } from './pages/Artists';
import { Labels } from './pages/Labels';
import { Albums } from './pages/Albums';
import { Songs } from './pages/Songs';
import { Frame } from './pages/Frame';
import { Home } from './pages/Home';

// this component is the root of the entire application
// EVERYTHING we want displayed on ANY page needs to be contained here, direclty or otherwise
// components are functions that can take in properties and return some TSX (HTML + TS)
function App() {
  
  // note that the return MUST have ONE parent component
  // if there isn't a parent component that makes sense, you can use an empty fragment
  return (
    <>
      {/* 
        the BrowserRouter from react-router contains several routes for the various pages
        if you don't use nested routes, you just set up a route for each page
        nested routes like the routes within the Frame route
        - allow us to skip rerendering components that are on every page
          by including them in the frame
        - allow us to set up different frames based on prefix,
          say, a frame for the admin users and their pages, but another for end users
        the routes for nested routes will TACK ON to the end of the parent route's string
       */}
      <BrowserRouter>
        <Routes>
          <Route path='/' element={<Frame />}>
            <Route index element={<Home />} />
            <Route path='labels' element={<Labels />} />
            <Route path='artists' element={<Artists />} />
            <Route path='albums' element={<Albums />} />
            <Route path='songs' element={<Songs />} />
          </Route>
        </Routes>
      </BrowserRouter>
    </>
  )
}

export default App
