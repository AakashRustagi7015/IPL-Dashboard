FROM node:slim

COPY package.json package-lock.json .

RUN npm install

COPY . .

RUN npm run build

EXPOSE 3000

CMD ["tail","-f","/dev/null"]
CMD ["npm","start"]

