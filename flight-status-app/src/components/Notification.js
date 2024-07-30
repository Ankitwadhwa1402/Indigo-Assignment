import React, { useState } from 'react';
import axios from 'axios';

const Notification = () => {
  const [email, setEmail] = useState('');
  const [phone, setPhone] = useState('');

  const handleSubscribe = () => {
    axios.post('/api/subscribe', { email, phone })
      .then(response => {
        alert('Subscribed successfully!');
      })
      .catch(error => {
        console.error('There was an error subscribing!', error);
      });
  };

  return (
    <div>
      <h1>Subscribe for Notifications</h1>
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
