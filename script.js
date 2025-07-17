const songs = [
  { title: "Ghost", file: "songs/Ghost.mp3", cover: "images/ghost.jpg" },
  { title: "Peaches", file: "songs/Peaches.mp3", cover: "images/peaches.jpeg" },
  { title: "Despacito", file: "songs/Despacito.mp3", cover: "images/Despacito.jpeg" },
  { title: "As Long As You Love Me", file: "songs/LoveMe.mp3", cover: "images/loveme.jpeg" },
  { title: "Yummy", file: "songs/Yummy.mp3", cover: "images/yummy.jpeg" },
  { title: "What Do You Mean", file: "songs/Mean.mp3", cover: "images/mean.jpeg" },
  { title: "Intentions", file: "songs/intentions.mp3", cover: "images/intentions.jpg" },
  { title: "Anyone", file: "songs/Anyone.mp3", cover: "images/Anyone.jpeg" },
  { title: "Baby", file: "songs/Baby.mp3", cover: "images/Baby.jpg" },
  { title: "Never Let You Go", file: "songs/Never.mp3", cover: "images/Never.jpeg" },
  { title: "Christmas Love", file: "songs/christmas.mp3", cover: "images/christmas.jpg" },
  { title: "Mistletoe", file: "songs/Mistletoe.mp3", cover: "images/mis.jpg" },
  
];

let currentSong = 0;
let lastPlayed = null;

const audio = document.getElementById('audio');
const cover = document.getElementById('cover');
const title = document.getElementById('song-title');
const artist = document.getElementById('artist');
const prevSongText = document.getElementById('prev-song');
const playPauseBtn = document.getElementById('play-pause');
const volumeSlider = document.getElementById('volume');
const progressBar = document.getElementById('progress');
const currentTimeEl = document.getElementById('current-time');
const durationEl = document.getElementById('duration');
const songListEl = document.getElementById('song-list');

function loadSong(index) {
  const song = songs[index];
  audio.src = song.file;
  cover.src = song.cover;
  title.textContent = song.title;
  artist.textContent = "Justin Bieber";
  if (lastPlayed !== null) {
    prevSongText.textContent = "Last Played: " + songs[lastPlayed].title;
  }
  lastPlayed = currentSong;
  updateSongList();
}

function togglePlay() {
  if (audio.paused) {
    audio.play();
    playPauseBtn.textContent = '⏸️';
  } else {
    audio.pause();
    playPauseBtn.textContent = '▶️';
  }
}

function nextSong() {
  currentSong = (currentSong + 1) % songs.length;
  loadSong(currentSong);
  audio.play();
  playPauseBtn.textContent = '⏸️';
}

function prevSong() {
  currentSong = (currentSong - 1 + songs.length) % songs.length;
  loadSong(currentSong);
  audio.play();
  playPauseBtn.textContent = '⏸️';
}

function setVolume(value) {
  audio.volume = value;
}

function seekTo(value) {
  audio.currentTime = (value / 100) * audio.duration;
}

audio.addEventListener('timeupdate', () => {
  const progress = (audio.currentTime / audio.duration) * 100;
  progressBar.value = progress || 0;

  currentTimeEl.textContent = formatTime(audio.currentTime);
  durationEl.textContent = formatTime(audio.duration);
});

function formatTime(seconds) {
  if (isNaN(seconds)) return '0:00';
  const min = Math.floor(seconds / 60);
  const sec = Math.floor(seconds % 60).toString().padStart(2, '0');
  return `${min}:${sec}`;
}

function updateSongList() {
  songListEl.innerHTML = '';
  songs.forEach((song, index) => {
    const li = document.createElement('li');
    li.textContent = song.title;
    if (index === currentSong) li.style.color = '#1db954';
    li.onclick = () => {
      currentSong = index;
      loadSong(currentSong);
      audio.play();
      playPauseBtn.textContent = '⏸️';
    };
    songListEl.appendChild(li);
  });
}

window.onload = () => {
  loadSong(currentSong);
  setVolume(0.5);
  updateSongList();
};
