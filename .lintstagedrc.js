module.exports = {
  '*.{sh,js,jsx,ts,tsx,css,scss,md,html,java,kotlin,xml,sql,sh,json,package.json}': [
    'prettier --write',
    'git add',
  ],
};
