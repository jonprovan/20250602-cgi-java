import { useState } from "react"
import { Footer } from "../components/Footer"
import { Header } from "../components/Header"
import { Outlet } from 'react-router'
import { FavoriteContext } from "../context/FavoriteContext"

/**
 * here, we create a context for use in any components it wraps around
 * this component will hold onto the context's state
 * we then pass that state on to any component that needs it via the context
 * this allows unrelated components to "speak" to one another without prop drilling
 * prop drilling = passing data up and down the chain, which is tight coupling and not good
 * you can have as many contexts as you need/want
 * just make sure you wrap whatever needs it in the context tag
 */
// see /context/FavoriteContext.ts for the export
// export const FavoriteContext = createContext('');

export const Frame = () => {

    // the state for our context
    // this default value is just what the original value of favorite will be
    const [ favorite, setFavorite ] = useState('');

    return (
        <>
            {/* this tag provides the FavoriteContext to any components within it */}
            {/* the value is whatever properties and/or methods we want to make available */}
            {/* value looks for ONE element only, so it's typically done via an array
                with the props/methods in it */}
            <FavoriteContext.Provider value={[ favorite, setFavorite ]}>
                <Header />

                {/* whatever content we want to display on a page will be inserted into the outlet, depending on which route is activated */}
                {/* even though we don't directly import any page components here, this Frame can be thought of as "importing" those components for the purposes of Context */}
                <Outlet />
            </FavoriteContext.Provider>

            <Footer />
        </>
    )

}