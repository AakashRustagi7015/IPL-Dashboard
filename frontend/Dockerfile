FROM node:slim

COPY package.json package-lock.json .

RUN npm install

COPY . .

RUN npm run build

EXPOSE 3000

CMD ["npm","start"]

