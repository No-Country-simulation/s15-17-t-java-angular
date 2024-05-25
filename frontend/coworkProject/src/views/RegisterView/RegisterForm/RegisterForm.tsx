import React from 'react';
import { useForm } from 'react-hook-form';

interface IFormInput {
	fullName: string;
	email: string;
	password: string;
}

export const RegisterForm: React.FC = () => {
	const { register, handleSubmit, formState: { errors } } = useForm<IFormInput>();

	const onSubmit = (data: IFormInput) => {
		console.log(data);
	};

	return (
		<form onSubmit={handleSubmit(onSubmit)} className="space-y-4 md:space-y-6">
			<div>
				<label htmlFor="fullName" className="block mb-2 text-sm font-medium text-gray-900">Nombre Completo</label>
				<input
					type="text"
					id="fullName"
					{...register("fullName", { required: "Full Name is required" })}
					className="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5"
				/>
				{errors.fullName && <p className="mt-2 text-sm text-red-600">{errors.fullName.message}</p>}
			</div>

			<div>
				<label htmlFor="email" className="block mb-2 text-sm font-medium text-gray-900">Email</label>
				<input
					type="email"
					id="email"
					{...register("email", { required: "Email is required", pattern: { value: /^\S+@\S+$/i, message: "Invalid email address" } })}
					className="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5"
				/>
				{errors.email && <p className="mt-2 text-sm text-red-600">{errors.email.message}</p>}
			</div>

			<div>
				<label htmlFor="password" className="block mb-2 text-sm font-medium text-gray-900">Contraseña</label>
				<input
					type="password"
					id="password"
					{...register("password", { required: "Password is required", minLength: { value: 6, message: "Password must be at least 6 characters" } })}
					className="bg-gray-50 border border-gray-300 text-gray-900 sm:text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5"
				/>
				{errors.password && <p className="mt-2 text-sm text-red-600">{errors.password.message}</p>}
			</div>

			<button type="submit" className="w-full text-white bg-primary-600 hover:bg-primary-700 focus:ring-4 focus:outline-none focus:ring-primary-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center">Register</button>
		</form>
	);
};
