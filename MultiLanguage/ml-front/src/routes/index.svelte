<script lang="ts">
    import type { Label } from "../lib/Label"
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

{#await labelPromise}
    <h1>Waiting for data</h1>
{:then data}
    {#each data as label}
        <h1>{fillVars(label.content, {test})}</h1>
    {/each}
{:catch}
    <h1>Something went wrong</h1>
{/await}