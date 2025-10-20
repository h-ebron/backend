import React, { useState } from "react";

export default function RegisterUser() {
  const [form, setForm] = useState({ name: "", email: "", password: "" });

  const handleSubmit = (e) => {
    e.preventDefault();
    alert(`User Registered!\nName: ${form.name}\nEmail: ${form.email}`);
  };

  return (
    <div style={{ padding: "20px" }}>
      <h2>User Registration</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label>Full Name: </label>
          <input
            type="text"
            value={form.name}
            onChange={(e) => setForm({ ...form, name: e.target.value })}
          />
        </div>
        <br />
        <div>
          <label>Email: </label>
          <input
            type="email"
            value={form.email}
            onChange={(e) => setForm({ ...form, email: e.target.value })}
          />
        </div>
        <br />
        <div>
          <label>Password: </label>
          <input
            type="password"
            value={form.password}
            onChange={(e) => setForm({ ...form, password: e.target.value })}
          />
        </div>
        <br />
        <button type="submit">Register</button>
      </form>
    </div>
  );
}


