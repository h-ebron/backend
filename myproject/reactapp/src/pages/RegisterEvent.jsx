import React, { useState } from "react";

export default function RegisterEvent() {
  const [event, setEvent] = useState({ name: "", date: "", participants: "" });

  const handleSubmit = (e) => {
    e.preventDefault();
    alert(
      `Event Registered!\nName: ${event.name}\nDate: ${event.date}\nParticipants: ${event.participants}`
    );
  };

  return (
    <div style={{ padding: "20px" }}>
      <h2>Event Registration</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label>Event Name: </label>
          <input
            type="text"
            value={event.name}
            onChange={(e) => setEvent({ ...event, name: e.target.value })}
          />
        </div>
        <br />
        <div>
          <label>Event Date: </label>
          <input
            type="date"
            value={event.date}
            onChange={(e) => setEvent({ ...event, date: e.target.value })}
          />
        </div>
        <br />
        <div>
          <label>Participants: </label>
          <input
            type="number"
            value={event.participants}
            onChange={(e) => setEvent({ ...event, participants: e.target.value })}
          />
        </div>
        <br />
        <button type="submit">Register Event</button>
      </form>
    </div>
  );
}
