<script lang="ts">
    import type { Label } from "../lib/Label"
    import en from '$lib/assets/en.png'
    import pl from '$lib/assets/pl.png'
    import Flag from '../components/Flag.svelte'
    export let labels: Label[] = []
    let test = "Hey, I have been called from Spring!"

    async function getLabel() {
        try {
            const url = "/labels"
            const response = await fetch(url, {
                method: 'GET'
            })
            return response.json()
        } catch (error) {
            console.log("Something went wrong...")
        }
    }

    const labelPromise = getLabel() ?? { labels }

    const fillVars = (content: string, vars: {} = {}) => {
        (Object.keys(vars) as Array<keyof typeof vars>).map((k) => {
            const regex = new RegExp('{{'+k+'}}', "g")
            content = content.replace(regex, vars[k])
        })

        return content
    }

</script>

<Flag alt="English" src={en} isSelected={true} />
<Flag alt="Polish" src={pl} />

{#await labelPromise}
    <h1>Waiting for data</h1>
{:then data}
    {#each data as label}
        <h1>{fillVars(label.content, {test})}</h1>
    {/each}
{:catch}
    <h1>Something went wrong</h1>
{/await}