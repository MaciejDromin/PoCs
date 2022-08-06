import { browser } from "$app/env"
import { writable } from 'svelte/store'

const storageName = "language"
const defaultVal = 'en'
const value = browser ? window.localStorage.getItem(storageName) ?? defaultVal : defaultVal

export const language = writable<string>(value)

language.subscribe((val) => {
    if (browser) {
        window.localStorage.setItem(storageName, val)
    }
})

export { language as default }