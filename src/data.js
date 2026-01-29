// Sample data for the school management system

export const classes = [
  { id: 1, name: '10A' },
  { id: 2, name: '10B' },
  { id: 3, name: '9A' },
];

export const teachers = [
  { id: 1, name: 'Mr. Smith', subjects: ['Math'] },
  { id: 2, name: 'Ms. Johnson', subjects: ['English'] },
  { id: 3, name: 'Mr. Brown', subjects: ['Science'] },
  { id: 4, name: 'Mrs. Davis', subjects: ['History', 'Geography'] },
  { id: 5, name: 'Ms. Miller', subjects: ['Art'] },
  { id: 6, name: 'Mr. Taylor', subjects: ['Physical Education'] },
  { id: 7, name: 'Mrs. Anderson', subjects: ['Music'] },
  { id: 8, name: 'Mr. Wilson', subjects: ['Computer Science'] },
  { id: 9, name: 'Ms. Garcia', subjects: ['Biology'] },
  { id: 10, name: 'Mr. Lee', subjects: ['Chemistry'] },
];

// Define schedules for each day
const daySchedules = {
  1: [ // Monday
    { period: 1, subject: 'Math', teacherId: 1 },
    { period: 2, subject: 'English', teacherId: 2 },
    { period: 3, subject: 'Science', teacherId: 3 },
    { period: 4, subject: 'History', teacherId: 4 },
    { period: 5, subject: 'Geography', teacherId: 4 },
    { period: 6, subject: 'Art', teacherId: 5 },
    { period: 7, subject: 'Physical Education', teacherId: 6 },
    { period: 8, subject: 'Music', teacherId: 7 },
  ],
  2: [ // Tuesday
    { period: 1, subject: 'Computer Science', teacherId: 8 },
    { period: 2, subject: 'Biology', teacherId: 9 },
    { period: 3, subject: 'Chemistry', teacherId: 10 },
    { period: 4, subject: 'English', teacherId: 2 },
    { period: 5, subject: 'Math', teacherId: 1 },
    { period: 6, subject: 'Music', teacherId: 7 },
    { period: 7, subject: 'Art', teacherId: 5 },
    { period: 8, subject: 'Physical Education', teacherId: 6 },
  ],
  3: [ // Wednesday
    { period: 1, subject: 'Science', teacherId: 3 },
    { period: 2, subject: 'Math', teacherId: 1 },
    { period: 3, subject: 'History', teacherId: 4 },
    { period: 4, subject: 'Geography', teacherId: 4 },
    { period: 5, subject: 'English', teacherId: 2 },
    { period: 6, subject: 'Computer Science', teacherId: 8 },
    { period: 7, subject: 'Biology', teacherId: 9 },
    { period: 8, subject: 'Chemistry', teacherId: 10 },
  ],
  4: [ // Thursday
    { period: 1, subject: 'English', teacherId: 2 },
    { period: 2, subject: 'Science', teacherId: 3 },
    { period: 3, subject: 'Math', teacherId: 1 },
    { period: 4, subject: 'Art', teacherId: 5 },
    { period: 5, subject: 'Music', teacherId: 7 },
    { period: 6, subject: 'Physical Education', teacherId: 6 },
    { period: 7, subject: 'Computer Science', teacherId: 8 },
    { period: 8, subject: 'Biology', teacherId: 9 },
  ],
  5: [ // Friday
    { period: 1, subject: 'History', teacherId: 4 },
    { period: 2, subject: 'Geography', teacherId: 4 },
    { period: 3, subject: 'Chemistry', teacherId: 10 },
    { period: 4, subject: 'Math', teacherId: 1 },
    { period: 5, subject: 'English', teacherId: 2 },
    { period: 6, subject: 'Science', teacherId: 3 },
    { period: 7, subject: 'Art', teacherId: 5 },
    { period: 8, subject: 'Music', teacherId: 7 },
  ],
};

export const days = [
  { id: 1, name: 'Monday' },
  { id: 2, name: 'Tuesday' },
  { id: 3, name: 'Wednesday' },
  { id: 4, name: 'Thursday' },
  { id: 5, name: 'Friday' },
];



export const timetable = (() => {
  const result = [];
  classes.forEach(classObj => {
    days.forEach(day => {
      daySchedules[day.id].forEach(periodData => {
        result.push({
          classId: classObj.id,
          dayId: day.id,
          period: periodData.period,
          subject: periodData.subject,
          teacherId: periodData.teacherId,
        });
      });
    });
  });
  return result;
})();