
import './home.css';


function Home(props) {
  return (
    <div className="home">
    <button onClick={() => props.history.push({ pathname : '/post' })}>
       click
    </button>
    </div>
  );
}

export default Home;