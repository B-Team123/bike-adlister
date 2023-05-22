import { keys } from './keys.js';

const filestackClient = filestack.init(keys.filestack);
const avatar = document.querySelector('.avatar');
const filestackOptions = {
  maxFiles:        1,
  imageMax:        [600, 600],
  transformations: {
    crop:   false,
    circle: true,
    rotate: false,
    force:  true
  },
  onUploadDone:    response => {
    const form = document.querySelector('#avatar-form');
    const hiddenInput = document.querySelector('#hidden-input');
    response.filesUploaded.forEach(file => {
      console.log(file);
      hiddenInput.value = file.url;
    });
    form.submit();
  },
};
avatar.addEventListener('click', function (e) {
  e.preventDefault();
  filestackClient.picker(filestackOptions).open();
})

const editProfileBtn = document.querySelector('.edit-btn');
const profileEditForm = document.querySelector('.profile-edit-form');
const profileEditOverlay = document.querySelector('.profile-edit-overlay');
const profileEditFormWrapper = document.querySelector('.profile-edit-wrapper');
let editFormData = new FormData();

const removeAttributes = (element, ...attributes) => {
  attributes.forEach(att => element.removeAttribute(att))
}

editProfileBtn.addEventListener('click', function () {
  profileEditFormWrapper.classList.toggle('hidden');
  console.log('fired')
});

profileEditOverlay.addEventListener('click', function(e) {
    editProfileBtn.click();
    editFormData.reset();
})
