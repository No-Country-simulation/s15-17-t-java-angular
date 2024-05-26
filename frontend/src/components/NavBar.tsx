import { useState } from "react";

export default function NavBar() {
  const [isMenuOpen, setIsMenuOpen] = useState(false);

  const toggleMenu = () => {
    setIsMenuOpen(!isMenuOpen);
  };

  return (
    <nav className="font-sans flex flex-col  lg:h-24 sm:flex-row sm:justify-between py-4 px-6 lg:px-24 bg-white shadow sm:items-center w-full">
      <div className="flex justify-between items-center">
        <a href="/#" className="lg:text-5xl text-3xl font-bold text-[#262626]">
          WoodWork
        </a>
        <button
          className="sm:hidden text-3xl text-[#262626]"
          onClick={toggleMenu}
        >
          &#9776;
        </button>
      </div>
      <div
        className={`sm:flex flex-col sm:flex-row sm:items-center space-x-10 ${
          isMenuOpen ? "block" : "hidden"
        } mt-4 sm:mt-0`}
      >
        <a
          href="/#about"
          className="text-lg no-underline mt-2 sm:mt-0 ml-2 text-[#262626] hover:text-[#262626]/30 font-bold"
        >
          Nosotros
        </a>
        <a
          href="/#prices"
          className="text-lg no-underline mt-2 sm:mt-0 ml-2 text-[#262626] hover:text-[#262626]/30 font-bold"
        >
          Precios
        </a>
        <a
          href="/#contact"
          className="text-lg no-underline mt-2 sm:mt-0 ml-2 text-[#262626] hover:text-[#262626]/30 font-bold"
        >
          Contacto
        </a>
        <button className="mt-2 sm:mt-0 w-40   bg-black hover:bg-black/80 hover:text-slate-300 text-slate-100 py-3 px-6">
          Ingresar
        </button>
      </div>
    </nav>
  );
}
