import { useState } from 'react';
import './App.css';
import Header from './components/Header';
import Sidebar from './components/Sidebar';
import Footer from './components/Footer';
import { ClassTimetable, TeacherTimetable } from './components/Timetable';

function App() {
  const [activeView, setActiveView] = useState('class');
  const [selectedClassId, setSelectedClassId] = useState(1);
  const [selectedTeacherId, setSelectedTeacherId] = useState(1);

  const renderMainContent = () => {
    if (activeView === 'class') {
      return <ClassTimetable classId={selectedClassId} onClassChange={setSelectedClassId} />;
    } else if (activeView === 'teacher') {
      return <TeacherTimetable teacherId={selectedTeacherId} onTeacherChange={setSelectedTeacherId} />;
    }
    return null;
  };

  return (
    <div className="App">
      <Header />
      <div className="app-body">
        <Sidebar activeView={activeView} setActiveView={setActiveView} />
        <main className="main-content">
          {renderMainContent()}
        </main>
      </div>
      <Footer />
    </div>
  );
}

export default App;
