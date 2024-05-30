const shareBtn = document.querySelector('.svg-icon.share');
const sharePanel = document.querySelector('.share-links');
const iconContainer = document.querySelector('.icon-container');

shareBtn.addEventListener('click', () => {
    shareBtn.classList.toggle('active');
    iconContainer.classList.toggle('active');
    sharePanel.classList.toggle('shown');
})