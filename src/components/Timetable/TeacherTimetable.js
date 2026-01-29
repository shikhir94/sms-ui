import React from 'react';
import { teachers, timetable, classes, days } from '../../data';
import '../Timetable.css';

function TeacherTimetable({ teacherId, onTeacherChange }) {
  const teacher = teachers.find(t => t.id === teacherId);

  // Create a map of dayId -> period -> {subject, className}
  const schedule = {};
  days.forEach(day => {
    schedule[day.id] = {};
    for (let period = 1; period <= 8; period++) {
      const entry = timetable.find(t => t.teacherId === teacherId && t.dayId === day.id && t.period === period);
      if (entry) {
        schedule[day.id][period] = {
          subject: entry.subject,
          className: classes.find(c => c.id === entry.classId)?.name || 'Unknown'
        };
      } else {
        schedule[day.id][period] = { subject: 'Free', className: '' };
      }
    }
  });

  return (
    <div className="timetable">
      <h2>Weekly Timetable - Teacher {teacher?.name}</h2>
      <div className="timetable-controls">
        <label>Teacher: </label>
        <select value={teacherId} onChange={(e) => onTeacherChange(Number(e.target.value))}>
          {teachers.map(t => (
            <option key={t.id} value={t.id}>{t.name}</option>
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
                      {entry.className}
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

export default TeacherTimetable;