import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import "./App.css";
import IndexView from "./views/IndexView/IndexView";
import Navbar from "./components/NavBar";
import Footer from "./components/Footer";
import LoginView from "./views/LoginView/LoginView";
import RegisterView from "./views/RegisterView/RegisterView";

function App() {
  return (
    <>
      <Router>
        <Navbar />
        <Routes>
          <Route path="/" element={<IndexView />} />
          <Route path="/login" element={<LoginView />} />
          <Route path="/register" element={<RegisterView />} />
        </Routes>
        <Footer />
      </Router>
    </>
  );
}

export default App;
