import React, { useState } from 'react'

export default function EmployeeForm() {
  const [form, setForm] = useState({ name: '', designation: '', location: '', salary: '' })
  const [submitted, setSubmitted] = useState(null)

  function handleChange(e) {
    const { name, value } = e.target
    setForm(prev => ({ ...prev, [name]: value }))
  }

  function handleSubmit(e) {
    e.preventDefault()
    // No POST required — just show the entered values
    setSubmitted(form)
  }

  return (
    <div className="container my-4">
      <h2>Employee Form</h2>
      <form onSubmit={handleSubmit} className="mt-3">
        <div className="mb-3">
          <label className="form-label">Name</label>
          <input name="name" value={form.name} onChange={handleChange} className="form-control" required />
        </div>

        <div className="mb-3">
          <label className="form-label">Designation</label>
          <input name="designation" value={form.designation} onChange={handleChange} className="form-control" />
        </div>

        <div className="mb-3">
          <label className="form-label">Location</label>
          <input name="location" value={form.location} onChange={handleChange} className="form-control" />
        </div>

        <div className="mb-3">
          <label className="form-label">Salary</label>
          <input name="salary" value={form.salary} onChange={handleChange} type="number" className="form-control" />
        </div>

        <button className="btn btn-primary" type="submit">Submit</button>
      </form>

      {submitted && (
        <div className="card mt-4">
          <div className="card-body">
            <h5 className="card-title">Submitted Data</h5>
            <p><strong>Name:</strong> {submitted.name}</p>
            <p><strong>Designation:</strong> {submitted.designation}</p>
            <p><strong>Location:</strong> {submitted.location}</p>
            <p><strong>Salary:</strong> {submitted.salary}</p>
          </div>
        </div>
      )}
    </div>
  )
}
