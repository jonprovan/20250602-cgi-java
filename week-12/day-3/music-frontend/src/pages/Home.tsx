export const Home = () => {

    return (
        <main>
            {/* when using local media, store them in the public folder
                any folders you have within the public are just fine
                when linking to them, React assumes the public folder is the root
                so, this relative path begins in the public folder */}
            <img src="images/vinyl-record.jpg" alt="Voice-O-Graph" />
            <h1>HOME</h1>
            <h2>Welcome to the Music API Frontend!</h2>
            <p>Lorem, ipsum dolor sit amet consectetur adipisicing elit. Quaerat corrupti ipsam minus veniam eos praesentium, perspiciatis id explicabo nobis inventore itaque fugit illum deserunt soluta officia possimus eum doloremque doloribus.</p>
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Suscipit natus necessitatibus odit laudantium. Voluptas mollitia voluptates itaque, quis explicabo fuga ipsum eaque quibusdam dolorum, laboriosam in esse temporibus quo aperiam?</p>
        </main>
    )

}