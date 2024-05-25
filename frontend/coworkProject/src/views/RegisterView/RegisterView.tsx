import { RegisterForm } from "./RegisterForm/RegisterForm";

const RegisterView = () => {
  return (
    <section className="bg-[#31543D] min-h-screen flex items-center">
      <div className="flex flex-col items-center justify-center px-6 py-8 mx-auto w-full md:w-1/2 lg:w-1/3 xl:w-1/4 md:items-end">
        <div className="w-full bg-white rounded-lg shadow md:mt-0 xl:p-0">
          <div className="p-6 space-y-1 md:space-y-3 sm:p-8">
            <h1 className="text-lg font-bold leading-tight tracking-tight text-[#31543D] md:text-2xl">
              ¡Únete a WoodWork!
            </h1>
            <p className="text-sm text-center leading-tight tracking-tight text-gray-900 md:text-2xl">
              Regístrate:
            </p>
            <RegisterForm />
          </div>
        </div>
      </div>
    </section>
  );
};

export default RegisterView;
