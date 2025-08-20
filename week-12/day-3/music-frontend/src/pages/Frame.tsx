import { Footer } from "../components/Footer"
import { Header } from "../components/Header"
import { Outlet } from 'react-router'

export const Frame = () => {

    return (
        <>
            <Header />

            {/* whatever content we want to display on a page will be inserted into the outlet, depending on which route is activated */}
            <Outlet />

            <Footer />
        </>
    )

}