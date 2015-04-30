clear;
load ProjectData2.mat;          % X is music file, Fs is sample freq
fsample = 44100;
taxis=1/Fs:1/Fs:10;

W = randn(1, 44100 *10);
    %Time domain of white noise
figure;
plot(taxis, W);
    %Power spectral density/frequency domain of white noise
figure;
pwelch(W);
    %Sound of white noise
sound(W, Fs);

    %Time domain of orignal
figure;
plot(taxis, X);
    %Power spectral density/frequency domain of original
figure;
pwelch(X);
    %Music file is X and frequency sample is Fs (already defined)
sound(X, Fs);

%Lowpass Filter
lowGp = 0.9;
lowGs = 0.01;
lowfp = 250;
lowfs = 750;
lowWp = convertWp(lowfp, fsample);
lowWs = convertWs(lowfs, fsample);
lowRp = convertRp(lowGp);
lowRs = convertRs(lowGs);
[lowN, lowWn] = ellipord(lowWp, lowWs, lowRp, lowRs);
[lowNum, lowDen] = ellip(lowN, lowRp, lowRs, lowWn, 'low');
    %Bode plot of lowpass filter
figure;
freqz(lowNum, lowDen);
    %Filtered sound
Ylw=filter(lowNum, lowDen, W);
Yl=filter(lowNum, lowDen, X);
    %Time domain of white noise from lowpass filter
figure;
plot(taxis, Ylw);
    %Time domain of output signal from lowpass filter
figure;
plot(taxis, Yl);
    %Power spectral density lowpass filtered white noise
figure;
pwelch(Ylw);
    %Power spectral density lowpass filtered music
figure;
pwelch(Yl);
    %Lowpass filtered white noise
sound(Ylw, Fs);
    %Lowpass filtered music file
sound(Yl, Fs);

%Bandpass Filter
bandGp = 0.9;
bandGs = 0.1;
bandfp = [700, 4500];
bandfs = [300, 5500];

bandWp = convertWp(bandfp, fsample);
bandWs = convertWs(bandfs, fsample);
bandRp = convertRp(bandGp);
bandRs = convertRs(bandGs);
[bandN, bandWn] = ellipord(bandWp, bandWs, bandRp, bandRs);
[bandNum,bandDen] = ellip(bandN, bandRp, bandRs, bandWn, 'bandpass');
    %Bode plot
figure;
freqz(bandNum, bandDen);
Ybw=filter(bandNum, bandDen, W);
Yb=filter(bandNum, bandDen, X);
    %Time domain of white noise from bandpass filter
figure;
plot(taxis, Ybw);
    %Time domain of output signal from bandpass filter
figure;
plot(taxis, Yb);
    %Power spectral density bandpass filtered white noise
figure;
pwelch(Ybw);
    %Power spectral density of bandpass filtered music
figure;
pwelch(Yb);
    %Bandpass filtered white noise
sound(Ybw, Fs);
    %Bandpass filtered music file
sound(Yb, Fs);

%Highpass Filter
highGp = 0.9;
highGs = 0.01;
highfp = 5500;
highfs = 4500;
highWp = convertWp(highfp, fsample);
highWs = convertWs(highfs, fsample);
highRp = convertRp(highGp);
highRs = convertRs(highGs);
[highN, highWn] = ellipord(highWp, highWs, highRp, highRs);
[highNum,highDen] = ellip(highN, highRp, highRs, highWn, 'high');
    %Bode plot
figure;
freqz(highNum, highDen);
Yhw=filter(highNum, highDen, W);
Yh=filter(highNum, highDen, X);
    %Time domain of white noise from highpass filter
figure;
plot(taxis, Yhw);
    %Time domain of output signal from highpass filter
figure;
plot(taxis, Yh);
    %Power spectral density highpass filtered white noise
figure;
pwelch(Yhw);
    %Power spectral density of highpass filtered music
figure;
pwelch(Yh);
    %Highpass filtered white noise
sound(Yhw, Fs);
    %Highpass filtered music file
sound(Yh, Fs);