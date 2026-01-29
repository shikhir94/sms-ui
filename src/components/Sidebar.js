import React from 'react';
import './Sidebar.css';

function Sidebar({ activeView, setActiveView }) {
  return (
    <nav className="sidebar">
      <ul>
        <li>
          <button
            className={activeView === 'class' ? 'active' : ''}
            onClick={() => setActiveView('class')}
          >
            Class View
          </button>
        </li>
        <li>
          <button
            className={activeView === 'teacher' ? 'active' : ''}
            onClick={() => setActiveView('teacher')}
          >
            Teacher View
          </button>
        </li>
      </ul>
    </nav>
  );
}

export default Sidebar;