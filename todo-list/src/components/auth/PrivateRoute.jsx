import { Navigate } from "react-router-dom";

const PrivateRoute = ({ children }) => {
  const isLoggedIn = !!localStorage.getItem("loggedInUser");

  return isLoggedIn ? children : <Navigate to="/login" replace />;
};

export default PrivateRoute;