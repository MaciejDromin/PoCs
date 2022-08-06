<script lang="ts">
    export let src:string = ''
    export let alt: string = ''
    export let isSelected:boolean = false
</script>

<div class:selected="{isSelected}" on:click>
    <img class="img-dims" alt="{alt}" src={src} />
</div>

<style>
.img-dims {
    max-width: 160px;
    max-height: 100px;
    cursor: pointer;
}
.selected {
    -webkit-filter: grayscale(100%);
       -moz-filter: grayscale(100%);
         -o-filter: grayscale(100%);
        -ms-filter: grayscale(100%);
            filter: grayscale(100%); 
}
</style>