import React from 'react';
import { useForm, SubmitHandler } from 'react-hook-form';

interface IFormInput {
  email: string;
  password: string;
}

export const LoginForm: React.FC = () => {
  const { register, handleSubmit, formState: { errors } } = useForm<IFormInput>();

  const onSubmit: SubmitHandler<IFormInput> = (data) => {
    console.log(data);
  };

  return (
    <form onSubmit={handleSubmit(onSubmit)} className="space-y-4 md:space-y-6">
      <div>
        <label htmlFor="email" className="block mb-2 text-sm font-medium text-[#31543D]">Email</label>
        <input
          type="email"
          id="email"
          {...register("email", { required: "*Email es requerido", pattern: { value: /^\S+@\S+$/i, message: "*Direccion de email no valida" } })}
          className="bg-[#D9D9D9] border border-[#A67C52] text-gray-900 sm:text-sm rounded-lg focus:ring-[#31543D] focus:border-[#31543D] block w-full p-2.5"
        />
        {errors.email && <p className="mt-2 text-sm text-red-600">{errors.email.message}</p>}
      </div>

      <div>
        <label htmlFor="password" className="block mb-2 text-sm font-medium text-[#31543D]">Contraseña</label>
        <input
          type="password"
          id="password"
          {...register("password", { required: "*Contraseña es requerida", minLength: { value: 6, message: "*Contraseña debe tener al menos 6 caracteres" } })}
          className="bg-[#D9D9D9] border border-[#A67C52] text-gray-900 sm:text-sm rounded-lg focus:ring-[#31543D] focus:border-[#31543D] block w-full p-2.5"
        />
        {errors.password && <p className="mt-2 text-sm text-red-600">{errors.password.message}</p>}
      </div>

      <button type="submit" className="w-full text-white bg-[#31543D] hover:bg-[#A67C52] focus:ring-4 focus:outline-none focus:ring-[#31543D] font-medium rounded-lg text-sm px-5 py-2.5 text-center">Iniciar Sesión</button>
    </form>
  );
};
