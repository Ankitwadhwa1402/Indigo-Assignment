import React, { useState } from 'react';
import axios from 'axios';

const Notification = () => {
  const [email, setEmail] = useState('');
  const [phone, setPhone] = useState('');
  const [flightId, setFlightId] = useState('');

  const handleSubscribe = () => {
    const notification = {
      flightId,
      message: `Subscribed to notifications for flight ${flightId}`,
      timestamp: new Date().toISOString(),
      method: email ? 'Email' : 'SMS',
      recipient: email || phone,
    };

    axios.post('/api/subscribe', notification)
      .then(response => {
        console.log('Subscription successful', response.data);
      })
      .catch(error => {
        console.error('There was an error subscribing!', error);
      });
  };

  return (
    <div>
      <h1>Subscribe for Notifications</h1>
      <input
        type="text"
        placeholder="Flight ID"
        value={flightId}
        onChange={(e) => setFlightId(e.target.value)}
      />
      <input
        type="email"
        placeholder="Email"
        value={email}
        onChange={(e) => setEmail(e.target.value)}
      />
      <input
        type="phone"
        placeholder="Phone"
        value={phone}
        onChange={(e) => setPhone(e.target.value)}
      />
      <button onClick={handleSubscribe}>Subscribe</button>
    </div>
  );
};

export default Notification;
