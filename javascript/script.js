console.log("Page script loaded.");

function validatePhone() {
    const phoneInput = document.getElementById('phone');
    const phonePattern = /^\d{3}-\d{3}-\d{4}$/;
    if (!phonePattern.test(phoneInput.value) && phoneInput.value !== '') {
        alert('Please enter a valid phone number in the format 123-456-7890.');
    }
    console.log('Phone field blurred. Validation checked.');
}

function displayFee() {
    const eventType = document.getElementById('eventType').value;
    const fees = { fair: '$10', concert: '$25', run: '$30' };
    document.getElementById('eventFee').value = fees[eventType];
    console.log(`Event type changed to: ${eventType}`);
}

function showConfirmation() {
    const name = document.getElementById('name').value;
    const confirmationMsg = document.getElementById('confirmationMessage');
    confirmationMsg.value = `Thank you, ${name}! Your registration is confirmed.`;
    console.log('Form submitted. Confirmation shown.');
    return false;
}

function enlargeImage(img) {
    const isEnlarged = img.style.transform === 'scale(1.5)';
    img.style.transform = isEnlarged ? 'scale(1.0)' : 'scale(1.5)';
    console.log(`Image dblclicked. Enlarged: ${!isEnlarged}`);
}

function countChars() {
    const messageLength = document.getElementById('message').value.length;
    document.getElementById('charCount').textContent = messageLength;
}

function videoReady() {
    document.getElementById('videoStatus').textContent = "Video is ready to play.";
    console.log('Video can play now.');
}

window.onbeforeunload = function() {
    const message = document.getElementById('message').value;
    if (message.length > 0) {
        return "You have unsaved changes in the form. Are you sure you want to leave?";
    }
};

const eventTypeSelect = document.getElementById('eventType');
const clearPrefsButton = document.getElementById('clearPrefs');

eventTypeSelect.addEventListener('change', () => {
    localStorage.setItem('preferredEvent', eventTypeSelect.value);
    console.log(`Saved preference to localStorage: ${eventTypeSelect.value}`);
});

window.addEventListener('load', () => {
    const savedEvent = localStorage.getItem('preferredEvent');
    if (savedEvent) {
        eventTypeSelect.value = savedEvent;
        displayFee();
        console.log(`Loaded preference from localStorage: ${savedEvent}`);
    }
});

clearPrefsButton.addEventListener('click', () => {
    localStorage.clear();
    sessionStorage.clear();
    alert('Your preferences have been cleared.');
    console.log('localStorage and sessionStorage cleared.');
});

document.getElementById('findEvents').addEventListener('click', () => {
    const status = document.getElementById('geoStatus');
    status.textContent = 'Locating…';

    const options = {
        enableHighAccuracy: true,
        timeout: 5000,
        maximumAge: 0
    };

    navigator.geolocation.getCurrentPosition(
        (position) => {
            const { latitude, longitude } = position.coords;
            status.textContent = `Your coordinates: Latitude ${latitude.toFixed(4)}, Longitude ${longitude.toFixed(4)}`;
            console.log('Geolocation success:', position);
        },
        (error) => {
            let errorMessage = 'An unknown error occurred.';
            switch (error.code) {
                case error.PERMISSION_DENIED:
                    errorMessage = 'Permission for Geolocation was denied.';
                    break;
                case error.POSITION_UNAVAILABLE:
                    errorMessage = 'Location information is unavailable.';
                    break;
                case error.TIMEOUT:
                    errorMessage = 'The request to get user location timed out.';
                    break;
            }
            status.textContent = `Error: ${errorMessage}`;
            console.error('Geolocation error:', error);
        },
        options
    );
});