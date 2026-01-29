import React from 'react';
import { classes, timetable, teachers, days } from '../../data';
import '../Timetable.css';

function ClassTimetable({ classId, onClassChange }) {
  const classObj = classes.find(c => c.id === classId);

  // Create a map of dayId -> period -> {subject, teacher}
  const schedule = {};
  days.forEach(day => {
    schedule[day.id] = {};
    for (let period = 1; period <= 8; period++) {
      const entry = timetable.find(t => t.classId === classId && t.dayId === day.id && t.period === period);
      if (entry) {
        schedule[day.id][period] = {
          subject: entry.subject,
          teacher: teachers.find(te => te.id === entry.teacherId)?.name || 'Unknown'
        };
      } else {
        schedule[day.id][period] = { subject: 'Free', teacher: '' };
      }
    }
  });

  return (
    <div className="timetable">
      <h2>Weekly Timetable - Class {classObj?.name}</h2>
      <div className="timetable-controls">
        <label>Class: </label>
        <select value={classId} onChange={(e) => onClassChange(Number(e.target.value))}>
          {classes.map(c => (
            <option key={c.id} value={c.id}>{c.name}</option>
          ))}
        </select>
      </div>
      <div className="timetable-grid">
        <table>
          <thead>
            <tr>
              <th>Day / Period</th>
              {Array.from({ length: 8 }, (_, i) => (
                <th key={i + 1}>Period {i + 1}</th>
              ))}
            </tr>
          </thead>
          <tbody>
            {days.map(day => (
              <tr key={day.id}>
                <td className="day-cell">{day.name}</td>
                {Array.from({ length: 8 }, (_, i) => {
                  const period = i + 1;
                  const entry = schedule[day.id][period];
                  return (
                    <td key={period} className="period-cell">
                      {entry.subject}<br />
                      {entry.teacher}
                    </td>
                  );
                })}
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}

export default ClassTimetable;