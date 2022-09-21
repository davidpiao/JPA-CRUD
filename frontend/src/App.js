import "./App.css";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import ListUser from "./components/ListUser";
import Header from "./components/Header";
import Footer from "./components/Footer";
import AddUser from "./components/AddUser";

function App() {
  return (
    <div>
      <Router>
        <Header />
        <div className="container">
          <Routes>
            <Route path="/" exact element={<ListUser />}></Route>
            <Route path="/users" exact element={<ListUser />}></Route>
            <Route path="/add-user" element={<AddUser />}></Route>
            <Route path="/edit-user/:id" exact element={<AddUser />}></Route>
          </Routes>
        </div>
        <Footer />
      </Router>
    </div>
  );
}

export default App;
