import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import "./App.css";
import IndexView from "./views/IndexView/IndexView";
import Navbar from "./components/NavBar";
import Footer from "./components/Footer";

function App() {
  return (
    <>
      <Router>
        <Navbar />
        <Routes>
          <Route path="/" element={<IndexView />} />
        </Routes>
        <Footer />
      </Router>
    </>
  );
}

export default App;
